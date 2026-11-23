package ni.edu.uam.administracionfx.config;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.File;

public class ExportarExcel implements IExportar{

    @Override
    public void exportar(JasperPrint jasperPrint, File destino)
            throws JRException
    {
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(
               new SimpleExporterInput(jasperPrint)
        );
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(destino)
        );
        SimpleXlsxReportConfiguration config
                = new SimpleXlsxReportConfiguration();
        config.setOnePagePerSheet(false);
        config.setDetectCellType(true);
        config.setRemoveEmptySpaceBetweenRows(true);
        config.setWhitePageBackground(false);
        exporter.setConfiguration(config);
        exporter.exportReport();
    }
}
