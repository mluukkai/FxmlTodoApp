package todoapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import todoapp.domain.TodoService;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TodoService todoApp = new TodoService(new FakeTodoDao(), new FakeUserDao());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginScene.fxml"));
            
        Parent root = loader.load();       
        LoginSceneController controller = loader.getController();
        controller.setTodoService(todoApp);
        
        Scene scene = new Scene(root);

        stage.setTitle("TodoApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
