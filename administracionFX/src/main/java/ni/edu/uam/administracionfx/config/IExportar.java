package ni.edu.uam.administracionfx.config;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;

public interface IExportar {
    void exportar(JasperPrint jasperPrint
            , File destino) throws JRException;
}
