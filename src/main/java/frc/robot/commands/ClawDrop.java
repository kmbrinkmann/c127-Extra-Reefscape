// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.GamePiece;
import frc.robot.Robot;
import frc.robot.subsystems.Algae;
import frc.robot.subsystems.Coral;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ClawDrop extends Command {
  private final Coral m_coral;
  private final Algae m_algae;  
  private final Timer timer = new Timer();
  private GamePiece subsystem;
  private double dropSpeed;

  /** Creates a new ClawDrop. */
  public ClawDrop(Coral coralSubsystem, Algae algaeSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_coral = coralSubsystem;
    addRequirements(m_coral);
    m_algae = algaeSubsystem;
    addRequirements(m_algae);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();

    if (Robot.getInstance().joystick.getLeftTriggerAxis() > 0.5) {
      subsystem = m_algae;
    } subsystem = m_coral;

    if (subsystem == m_coral) {
      if (Robot.getInstance().goalArrangement == "L1"){
        dropSpeed = -0.5;
      } else if (Robot.getInstance().goalArrangement == "L4"){
        dropSpeed = -0.25;
      } else dropSpeed = -1;
    } dropSpeed = -1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsystem.rotateOutwards(dropSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.zero();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(0.5) && !Robot.getInstance().getCoralDetect();
  }
}
