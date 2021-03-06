/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.fulldummy.commands;

import edu.wpi.first.wpilibj.fulldummy.RobotMap;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author OAmour
 */
public class MoveServo extends CommandBase {
   
    public MoveServo() {
        // Use requires() here to declare subsystem dependencies
        requires(axiscam);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       if (oi.absoluteServoMode()){
         axiscam.moveServo(oi.getServoVert(),oi.getServoHoriz());
       } else {
         axiscam.setServo(oi.getServoVert(),oi.getServoHoriz());
       }        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
