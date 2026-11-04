module ni.edu.uam.administracionfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens ni.edu.uam.administracionfx to javafx.fxml;

    opens ni.edu.uam.administracionfx.model to
            org.hibernate.orm.core,
            jakarta.persistence;

    exports ni.edu.uam.administracionfx;
    exports ni.edu.uam.administracionfx.model;
}