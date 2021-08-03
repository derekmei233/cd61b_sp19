public class Body{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static double G = 6.67 * Math.pow(10, -11);
    public Body(double xP, double yP, double xV, double yV, double m, String img){
         xxPos = xP;
         yyPos = yP;
         xxVel = xV;
         yyVel = yV;
         mass = m;
         imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body pairb){
        double result = Math.sqrt(Math.pow(this.xxPos - pairb.xxPos, 2)
         + Math.pow(this.yyPos - pairb.yyPos, 2));
        return result;
    }
    public double calcForceExertedBy(Body pairb){
        double force = G * this.mass * pairb.mass /
         ( Math.pow(this.xxPos - pairb.xxPos, 2) + Math.pow(this.yyPos - pairb.yyPos, 2));
         return force;
    }
    public double calcForceExertedByX(Body pairb){
        double force = this.calcForceExertedBy(pairb);
        double forcex = force * (pairb.xxPos - this.xxPos) / this.calcDistance(pairb);
        return forcex;
    }
    public double calcForceExertedByY(Body pairb){
        double force = this.calcForceExertedBy(pairb);
        double forcey = force * (pairb.yyPos - this.yyPos) / this.calcDistance(pairb);
        return forcey;
    }
    public double calcNetForceExertedByX(Body[] pairs){
        double netForceX = 0;
        for (int i =0; i < pairs.length; i ++){
            if (this.equals(pairs[i])){
                continue;
            }
            netForceX += this.calcForceExertedByX(pairs[i]);
        }
        return netForceX;
    }
    public double calcNetForceExertedByY(Body[] pairs){
        double netForceY = 0;
        for (int i = 0; i < pairs.length; i ++){
            if (this.equals(pairs[i])){
                continue;
            }
            netForceY += this.calcForceExertedByY(pairs[i]);
        }
        return netForceY;
    }
    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
    public void draw(){
        String targetfile = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, targetfile);
    }
}