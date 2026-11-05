package ni.edu.uam.administracionfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ni.edu.uam.administracionfx.dao.*;
import ni.edu.uam.administracionfx.model.Usuario;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*IUsuarioDao usuarioDao = new UsuarioDao();
        Usuario u = new Usuario();
        u = usuarioDao.findById("39ea00ff-6759-4dde-a998-c7f38f43a9b9").orElse(null);
        System.out.println(u);
        usuarioDao.delete(u);
        usuarioDao.listAll().forEach(System.out::println);*/
        /*u.setPrimerNombre("Jose");
        u.setSegundoNombre("Carlos");
        u.setPrimerApellido("Lopez");
        u.setSegundoApellido("Lopez");
        u.setCorreo("jc@uamv.edu.ni");
        u.setUsuario("jclopez");
        u.setPassword("1234");
        usuarioDao.save(u);
        usuarioDao.listAll().forEach(System.out::println);*/
        //launch();
        IDao dao = new ImplDao();
        Usuario u = new Usuario();
        u.setPrimerNombre("Jose");
        u.setSegundoNombre("Carlos");
        u.setPrimerApellido("Lopez");
        u.setSegundoApellido("Lopez");
        u.setCorreo("jc@uamv.edu.ni");
        u.setUsuario("jclopez");
        u.setPassword("1234");
        dao.insert(u);
        List<Usuario> usuarios = dao.getAll("Usuario.findAll",Usuario.class);
        usuarios.forEach(System.out::println);
    }
}