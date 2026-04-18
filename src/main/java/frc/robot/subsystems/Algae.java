// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.GamePiece;
import frc.robot.Robot;

public class Algae extends GamePiece {
  /** Creates a new Algae. */

  private SparkMax clawMotor;

  public Algae() {

    clawMotor = new SparkMax(17, SparkLowLevel.MotorType.kBrushless);
    SparkMaxConfig sparkMaxConfig = new SparkMaxConfig();
    sparkMaxConfig.inverted(true);
    sparkMaxConfig.idleMode(IdleMode.kBrake);
    sparkMaxConfig.smartCurrentLimit(5, 10);
    clawMotor.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Algae", Robot.getInstance().getAlgaeDetect());
  }


}