/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.fulldummy.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author FrankAdmin
 */
public class AutonomousGroup extends CommandGroup {
    
    public AutonomousGroup() {        
        // Drive forward for 1 rotation
        //addSequential(new DriveForDistance(2*3.14*8.5, 0.1));
        //addSequential(new WaitForTime(2));
        addSequential(new TurnForDegrees(90));
        addSequential(new WaitForTime(2));
        addSequential(new TurnForDegrees(-90));
        //addSequential(new ReverseDriveForDistance(2*3.14*8.5, 0.1));
        // Drive until 100 mm away
        //addSequential(new DriveUntilDistance(100));
    }
}
