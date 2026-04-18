package frc.robot;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GamePiece extends SubsystemBase{
  public SparkMax clawMotor;
  private GamePiece subsystem;

  public void rotateInwards(double intakeSpeed) {
    clawMotor.set(intakeSpeed);
  }

  public void rotateOutwards(double dropSpeed) {
    clawMotor.set(dropSpeed);
  }

  public void zero() {
    clawMotor.set(0);
  }
}
