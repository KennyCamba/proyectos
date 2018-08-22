/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starFall;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author https://stackoverflow.com/questions/31909458/javafx-animation-move-shape-star-randomly
 */
public class StarFall extends Application
{

    private Polygon star;
    private Timeline timeline;
    private final double shs = 5.0; // Star Hand Size
    private final Random random = new Random();


    @Override
    public void start( Stage primaryStage )
    {
        // init shape
        Pos initPos = getRandomPos();
        star = new Polygon();
        star.setLayoutX( initPos.x );
        star.setLayoutY( initPos.y );
        star.setFill( Color.YELLOW );

        // the shape
        star.getPoints().addAll( new Double[]
        {
            0.0, shs * 3,
            shs * 2, shs * 2,
            shs * 3, 0.0,
            shs * 4, shs * 2,
            shs * 6, shs * 3,
            shs * 4, shs * 4,
            shs * 3, shs * 6,
            shs * 2, shs * 4
        } );

        // init timeline
        timeline = new Timeline();
        timeline.setCycleCount( Timeline.INDEFINITE );
        timeline.setAutoReverse( false );

        // init button
        Button btnStart = new Button( "Do Animation" );
        btnStart.setOnAction( ( e ) -> playNextKeyFrame() );

        Button btnStop = new Button( "Stop Animation" );
        btnStop.setLayoutX( 200 );
        btnStart.setLayoutX( 0 );
        btnStop.setOnAction( ( e ) -> timeline.stop() );

        // init scene with root
        AnchorPane root = new AnchorPane( btnStart, btnStop, star );
        Scene scene = new Scene( root, 800, 600 );

        //playNextKeyFrame();
                
        // show
        primaryStage.setScene( scene );
        primaryStage.show();
    }


    private void playNextKeyFrame()
    {
        // generate next random start and end positions for star
        Pos startPos = getRandomPos();
        Pos endPos = getRandomPos();

        // initial values (resetting)
        star.setLayoutX( startPos.x );
        star.setLayoutY( startPos.y );
        star.setScaleX( 1 );
        star.setScaleY( 1 );
        star.setOpacity( 1 );

        // target values
        KeyValue kx = new KeyValue( star.layoutXProperty(), endPos.x );
        KeyValue ky = new KeyValue( star.layoutYProperty(), endPos.y );
        KeyValue kScaleX = new KeyValue( star.scaleXProperty(), 3 );
        KeyValue kScaleY = new KeyValue( star.scaleYProperty(), 3 );
        KeyValue kFade = new KeyValue( star.opacityProperty(), 0.0 );

        // delay animation before start. Use this instead of THread.sleep() !!
        timeline.setDelay( Duration.millis( random.nextInt( 2000 ) + 100 ) );

        KeyFrame kf = new KeyFrame( 
                        Duration.millis( 3000 ),
                        e -> playNextKeyFrame(), 
                        kx, 
                        ky, 
                        kFade, 
                        kScaleX, 
                        kScaleY);
        
        // restart timeline with new values
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }


    private Pos getRandomPos()
    {
        int x = random.nextInt( 500 );
        int y = random.nextInt( 400 );
        Pos p = new Pos();
        p.x = x + 200;
        p.y = y + 200;
        return p;
    }


    private class Pos
    {
        int x;
        int y;
    }


    public static void main( String[] args )
    {
        launch( args );
    }

}
