public class NBody{
    public static double readRadius(String file){
        In in = new In(file);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Body[] readBodies(String file){
        In in = new In(file);
        int num = in.readInt();
        in.readDouble();
        Body[] planets = new Body[num];
        for (int i = 0; i < num; i++){
            planets[i] = new Body(in.readDouble(), in.readDouble(),
            in.readDouble(), in.readDouble(), in.readDouble(),
            in.readString());
        }
        return planets;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] planets = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (Body i : planets){
            i.draw();
        }
        StdDraw.show();
        StdDraw.pause(10);

        double[] force_x = new double[planets.length];
        double[] force_y = new double[planets.length];
        for (float current_t = 0; current_t < T; current_t += dt){
            StdDraw.clear();
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (int index = 0; index < planets.length; index += 1){
                force_x[index] = planets[index].calcNetForceExertedByX(planets);
                force_y[index] = planets[index].calcNetForceExertedByY(planets);
            }
            for (int index = 0; index < planets.length; index += 1){
                planets[index].update(dt, force_x[index], force_y[index]);
                planets[index].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdDraw.pause(1000);
    }
}