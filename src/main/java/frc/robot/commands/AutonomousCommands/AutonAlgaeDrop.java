// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Algae;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonAlgaeDrop extends Command {
  
  private final Algae m_algae;
  private Timer timer = new Timer();

  /** Creates a new ClawDrop. */
  public AutonAlgaeDrop(Algae subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
   
    m_algae = subsystem2;
    addRequirements(m_algae);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_algae.algaeRotateOutwards();

    if (!Robot.getInstance().getCoralDetect()) {
      timer.start();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_algae.algaeZero();
    timer.reset();
    timer.stop();
    if (Robot.COMMAND_DEBUG) System.out.println("end claw");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !Robot.getInstance().getAlgaeDetect() && timer.hasElapsed(.5);
  }
}