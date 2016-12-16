package com.drediki.exp.graphics;

import java.util.Random;

public class ShapeFactory {
    public static int MAXRANDNUM = 1000;
    public static int MAXRANDLEN = 1000;

    public static String[] names = {"Green", "Jobs", "Bill", "Lei", "Twilight", "Pinkie", "LiHua", "Jack"};
    private CreateShape[] creators = {new CircleCreator(), new OvalCreator(), new RectangleCreator(), new RegularHexagonCreator(), new SquareCreator()};
    private Random random;

    public ShapeFactory() {
        random = new Random();
    }

    public String createRandomName() {
        if (random == null) random = new Random();
        return names[random.nextInt(names.length)] + random.nextInt(MAXRANDNUM);
    }

    public Shape createRandomSpecificShape(int type) {
        return creators[type].createShape(createRandomName());
    }

    public Shape createRandomShape() {
        return createRandomSpecificShape(random.nextInt(creators.length));
    }

    //Shapes Creators
    public interface CreateShape {
        public Shape createShape(String name);
    }

    public class CircleCreator implements CreateShape {
        @Override
        public Shape createShape(String name) {
            // TODO Auto-generated method stub
            return new Circle(name, random.nextInt(MAXRANDLEN));
        }
    }

    public class OvalCreator implements CreateShape {
        @Override
        public Shape createShape(String name) {
            // TODO Auto-generated method stub
            return new Oval(name, random.nextInt(MAXRANDLEN), random.nextInt(MAXRANDLEN));
        }
    }

    public class RectangleCreator implements CreateShape {
        @Override
        public Shape createShape(String name) {
            // TODO Auto-generated method stub
            return new Rectangle(name, random.nextInt(MAXRANDLEN), random.nextInt(MAXRANDLEN));
        }
    }

    public class RegularHexagonCreator implements CreateShape {
        @Override
        public Shape createShape(String name) {
            // TODO Auto-generated method stub
            return new RegularHexagon(name, random.nextInt(MAXRANDLEN));
        }
    }

    public class SquareCreator implements CreateShape {
        @Override
        public Shape createShape(String name) {
            // TODO Auto-generated method stub
            return new Square(name, random.nextInt(MAXRANDLEN));
        }
    }

}