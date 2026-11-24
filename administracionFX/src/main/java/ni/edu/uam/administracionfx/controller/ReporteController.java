package ni.edu.uam.administracionfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import ni.edu.uam.administracionfx.config.ExportarExcel;
import ni.edu.uam.administracionfx.config.ExportarPDF;
import ni.edu.uam.administracionfx.service.ReportService;

import java.io.File;

public class ReporteController {

    @FXML
    private Button btnPDF;
    @FXML
    private Button btnExcel;

    private final ReportService reportService;

    public ReporteController(ReportService reportService) {
        this.reportService = reportService;
    }
    @FXML
    private void exportarPDF(ActionEvent event) {
        generarReporte("pdf");
    }
    @FXML
    private void exportarExcel(ActionEvent event) {
        generarReporte("xlsx");
    }

    private void generarReporte(String extension){
        FileChooser fc = new FileChooser();
        fc.setInitialFileName("ReporteUsuario" + "." + extension);
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Reporte","*." + extension
                )
        );
        File archivo = fc.showSaveDialog(null);
        if (archivo != null) {
            return;
        }
        try {
            if (extension.equals("PDF")) {
                reportService.exportar(new ExportarPDF(),archivo,extension);
            }
            else {
                reportService.exportar(new ExportarExcel(),archivo,extension);
            }
            new Alert(Alert.AlertType.INFORMATION
                    , "Reporte exported successfully")
                    .showAndWait();
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.ERROR
                    , e.getMessage())
                    .showAndWait();
        }

    }
}
