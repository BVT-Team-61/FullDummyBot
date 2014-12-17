/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.fulldummy.commands;

/**
 *
 * @author 2015-15
 */
public class TurnForDegrees extends CommandBase {
    
    private static final double kScale = 0.003;
    private static final double kThresh = 2.0;
    private double target;
    private double angle;
    private double error;
    
    public TurnForDegrees(double angle) {
        requires(drivetrain);
        requires(gyro);
        setTimeout(10); // If turning for more than 10 seconds, somethings wrong.
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        target = gyro.getAngle() + angle;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        error = target - gyro.getAngle();
        double vel = error*kScale;
        if(vel > 1) vel = 1;
        if(vel < -1) vel = -1;
        drivetrain.tankDrive(vel, -vel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Math.abs(error) > kThresh) || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.tankDrive(0.0,0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
