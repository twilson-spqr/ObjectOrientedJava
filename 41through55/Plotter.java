import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Plotter extends Application {
  private double x, y, x2, y2;
  private boolean up, down, left, right;
  private boolean up2, down2, left2, right2;

  public void start(Stage stage) {
    Group root = new Group();
    Scene scene = new Scene(root);

    Canvas canvas = new Canvas(900,700);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    x = 300;
    y = 350;
    x2 = 600;
    y2 = 350;
    int speed = 7;

    scene.addEventHandler(KeyEvent.KEY_PRESSED,
      new EventHandler<KeyEvent>() {
        public void handle(KeyEvent t) {
          if ( t.getCode() == KeyCode.W )
            up = true;
          if ( t.getCode() == KeyCode.S )
            down = true;
          if ( t.getCode() == KeyCode.A )
            left = true;
          if ( t.getCode() == KeyCode.D )
            right = true;
          if (t.getCode() == KeyCode.UP )
            up2 = true;
          if (t.getCode() == KeyCode.DOWN )
            down2 = true;
          if (t.getCode() == KeyCode.LEFT )
            left2 = true;
          if (t.getCode() == KeyCode.RIGHT )
            right2 = true;

          if ( t.getCode() == KeyCode.DIGIT1 )
            gc.setFill(Color.BLACK);
          else if ( t.getCode() == KeyCode.DIGIT2 )
            gc.setFill(Color.RED);
          else if ( t.getCode() == KeyCode.DIGIT3 )
            gc.setFill(Color.GREEN);
          else if ( t.getCode() == KeyCode.DIGIT4 )
            gc.setFill(Color.BLUE);
        }
      });

    scene.addEventHandler(KeyEvent.KEY_RELEASED,
      new EventHandler<KeyEvent>() {
        public void handle(KeyEvent t) {
          if (t.getCode() == KeyCode.W )
            up = false;
          if (t.getCode() == KeyCode.S )
            down = false;
          if (t.getCode() == KeyCode.A )
            left = false;
          if (t.getCode() == KeyCode.D )
            right = false;
          if (t.getCode() == KeyCode.UP )
            up2 = false;
          if (t.getCode() == KeyCode.DOWN )
            down2 = false;
          if (t.getCode() == KeyCode.LEFT )
            left2 = false;
          if (t.getCode() == KeyCode.RIGHT )
            right2 = false;
        }
      });

      root.getChildren().add(canvas);
      stage.setTitle("Plotter");
      stage.setScene(scene);
      stage.show();

      new AnimationTimer() {
        public void handle(long now) {
          if ( up )
            y -= speed;
          if ( down )
            y += speed;
          if ( left )
            x -= speed;
          else if ( right )
            x += speed;

          if ( up2 )
            y2 -= speed;
          if ( down2 )
            y2 += speed;
          if ( left2 )
            x2 -= speed;
          else if ( right2 )
            x2 += speed;

          gc.fillRect(x,y,20,20);
          gc.fillRect(x2,y2,20,20);
        }
    }.start();
  }
}
