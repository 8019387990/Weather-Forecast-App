import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WeatherApp extends Application {
    private Label tempLabel = new Label("Temperature:");
    private Label humidityLabel = new Label("Humidity:");
    private Label descLabel = new Label("Description:");
    private ImageView weatherIcon = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        TextField cityInput = new TextField();
        cityInput.setPromptText("Enter city name");
        Button fetchButton = new Button("Get Weather");

        fetchButton.setOnAction(e -> {
            String city = cityInput.getText().trim();
            if (!city.isEmpty()) {
                WeatherService.fetchWeather(city, tempLabel, humidityLabel, descLabel, weatherIcon);
            }
        });

        VBox root = new VBox(10, cityInput, fetchButton, tempLabel, humidityLabel, descLabel, weatherIcon);
        root.setPadding(new Insets(20));

        primaryStage.setTitle("Weather Forecast App");
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
