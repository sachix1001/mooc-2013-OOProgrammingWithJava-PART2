package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
        initializeApple();

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        while (continues) {
            worm.move();
            if (worm.runsInto(apple)) {
                worm.grow();
                createApple();
            }
            if (worm.runsIntoItself()) {
                continues = false;
            }

            if (this.isoutsideBorder()) {
                continues = false;
            }

            updatable.update();
            this.setDelay(1000 / worm.getLength());

            return;
        }

    }

    private void initializeApple() {
        Random r = new Random();
        int x = r.nextInt(width);
        int y = r.nextInt(height);

        while (x == width / 2 && y == height / 2) {
            x = r.nextInt(width);
            y = r.nextInt(height);
        }
        this.apple = new Apple(x, y);
    }

    private void createApple() {
        Random r = new Random();
        int x = r.nextInt(width);
        int y = r.nextInt(height);

        this.apple = new Apple(x, y);
    }

    public boolean isoutsideBorder() {
        boolean outsideBorder = false;
        Piece head = worm.getPieces().get(worm.getLength() - 1);
        if (this.width == head.getX()) {
            if (worm.getDirection() == Direction.RIGHT) {
                outsideBorder = true;
            }
        } else if (0 == head.getX()) {
            if (worm.getDirection() == Direction.LEFT) {
                outsideBorder = true;
            }
        } else if (this.height == head.getY()) {
            if (worm.getDirection() == Direction.DOWN) {
                outsideBorder = true;
            }
        } else if (0 == head.getY()) {
            if (worm.getDirection() == Direction.UP) {
                outsideBorder = true;
            }
        }
        return outsideBorder;
    }
}
