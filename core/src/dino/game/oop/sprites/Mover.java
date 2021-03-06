package dino.game.oop.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Mover {
    private static final int GRAVITY = -15;
    public static final int  MOVEMENT = 200;

    private Rectangle bounds;
    private Vector3 position;
    private Vector3 velocity;
    private Animation birdAnimation;

    private boolean fall;

    Texture texture = new Texture("white-dot.png");

    public Mover(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        birdAnimation = new Animation(new TextureRegion(texture), 3,0.5f);
        bounds = new Rectangle(x, y, texture.getWidth()/3, texture.getHeight());

    }

    public void update(float dt){
        birdAnimation.update(dt);
        if (position.y > 0 && fall) {
            velocity.add(0, 0,0);
        }else if (position.y < 0 && !fall){
            velocity.add(0, 0,0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt ,velocity.y, 0);
        velocity.scl(1/dt);
        if (position.y < 0){
            position.y = 0;
        }
        bounds.setPosition(position.x, position.y);
        System.out.println(dt);
    }

    public void updateAnimation(float dt){
        birdAnimation.update(dt);
    }
    public Vector3 getPosition() {
        return position;
    }


    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }
    public void dispose(){
        texture.dispose();
    }

}
