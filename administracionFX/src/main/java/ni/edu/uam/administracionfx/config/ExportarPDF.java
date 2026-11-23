package ni.edu.uam.administracionfx.config;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;

public class ExportarPDF implements IExportar{


    @Override
    public void exportar(JasperPrint jasperPrint
            , File destino) throws JRException
    {
        JasperExportManager.exportReportToPdfFile(
                jasperPrint,destino.getAbsolutePath());
    }
}
