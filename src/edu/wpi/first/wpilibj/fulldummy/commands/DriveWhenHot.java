/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.fulldummy.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author 2015-15
 */
public class DriveWhenHot extends CommandBase {

    public DriveWhenHot() {
        requires(drivetrain);
        requires(axiscam);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        axiscam.detectTargets();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        axiscam.detectTargets();
        if(axiscam.hotTargetFound()) {
            drivetrain.tankDrive(0.5,0.5);
        } else {
            drivetrain.tankDrive(0.0, 0.0);
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
