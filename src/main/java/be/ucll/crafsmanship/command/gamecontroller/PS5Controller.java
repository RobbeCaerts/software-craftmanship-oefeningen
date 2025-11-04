package be.ucll.crafsmanship.command.gamecontroller;

public class PS5Controller {
    private Command crossCommand;
    private Command triangleCommand;
    private Command squareCommand;
    private Command circleCommand;

    public PS5Controller(){}

    public void setCrossButton(Command command){
        this.crossCommand = command;
    }

    public void setTriangleButton(Command command){
        this.triangleCommand = command;
    }

    public void setSquareButton(Command command){
        this.squareCommand = command;
    }

    public void setCircleButton(Command command){
        this.circleCommand = command;
    }

    public void pressCross(){
        this.crossCommand.execute();
    }

    public void pressTriangle(){
        this.triangleCommand.execute();
    }

    public void pressSquare(){
        this.squareCommand.execute();
    }

    public void pressCircle(){
        this.circleCommand.execute();
    }
}
