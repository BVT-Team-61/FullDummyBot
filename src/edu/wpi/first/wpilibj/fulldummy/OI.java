
package edu.wpi.first.wpilibj.fulldummy;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.fulldummy.commands.LightToggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

   private static boolean reverseDriveMode=false;
   private static boolean absoluteServoControl=false;
   // Define Joystick Objects
   Joystick jLeft = new Joystick(RobotMap.leftStick);    
   Joystick jRight = new Joystick(RobotMap.rightStick);
   Joystick jCam = new Joystick(RobotMap.camStick);
   
   // Define Joystick Buttons
   Button reverseButton = new JoystickButton (jRight,1);
   Button lightButton = new JoystickButton (jCam,1);
   Button absoluteButton = new JoystickButton (jCam,2);
   
   public OI(){
       lightButton.whenPressed(new LightToggle());
   }
    // Placeholder method. Does nothing yet.
    public boolean weAreDriving() {
        return true;
    }
    
    // Determines if robot in reverse.
    public boolean weAreReversing (){
        // If the reverse button is hit, swap the value.
        if (reverseButton.get()) {
            reverseDriveMode = !reverseDriveMode;
        }
        // Otherwise, just return whatever it was before
        return reverseDriveMode ;
    }
    
    public boolean absoluteServoMode() {
        // If the absolute button is hit, swap the value.
        if (absoluteButton.get()) {
            absoluteServoControl = !absoluteServoControl;
        }
        // Otherwise, just return whatever it was before
        return absoluteServoControl;
    }
    // Method to return the left joystick Y Axis.
    public double getLeftSpeed() {
        return (jLeft.getY()); 
    }
    
    // Same thing but for the right joystick Y Axis.
    public double getRightSpeed() {
        return (jRight.getY());
    }
    
    public double getServoVert(){
        return (jCam.getX());
    }
    public double getServoHoriz(){
        return (jCam.getY());
    }
}

