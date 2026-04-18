// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Algae;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonAlgaeCarry extends Command {
  private final Algae m_algae;
  /** Creates a new AutonAlgaeCarry. */
  public AutonAlgaeCarry(Algae subsystem) {
    
    m_algae = subsystem;
    addRequirements(m_algae);
  }
// run this with a race group or deadline group in pathplanner
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_algae.algaeRotateInwards();
  }

  @Override
  public void end(boolean interrupted) {}
    
  @Override
  public boolean isFinished() {
    return false;
  }
}
