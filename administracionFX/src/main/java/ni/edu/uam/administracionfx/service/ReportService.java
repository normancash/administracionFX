package ni.edu.uam.administracionfx.service;

import net.sf.jasperreports.engine.*;
import ni.edu.uam.administracionfx.config.IExportar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReportService {

    private final IExportar expo;

    public ReportService(IExportar expo) {
        this.expo = expo;
    }


    public enum Formato {
        PDF,XLSX
    }

    public void exportar(File destino
            , Formato formato) throws SQLException
            , JRException, IOException
    {
        String url = System.getenv().getOrDefault(
          "DB_URL"
             , "jdbc:postgresql://localhost:5432/estudiante"
        );
        String usuario = System.getenv().getOrDefault(
                "DB_USER","postgres"
        );
        String password = System.getenv().getOrDefault(
                "DB_PASSWORD","1234"
        );
        try(InputStream plantilla = getClass()
                .getResourceAsStream("/reports/usuarios.jrxml");
           Connection connection = DriverManager.getConnection(url
                   , usuario, password);)
        {
          JasperReport jasperReport =
                  JasperCompileManager.compileReport(plantilla);
          Map<String, Object> parameters = new HashMap<>();
          if (formato == Formato.XLSX) {
              parameters.put(JRParameter.IS_IGNORE_PAGINATION,Boolean.TRUE);
          }
          JasperPrint jasperPrint = JasperFillManager.fillReport(
                  jasperReport,
                  parameters,
                  connection
          );
          expo.exportar(jasperPrint, destino);
        }
    }
}
