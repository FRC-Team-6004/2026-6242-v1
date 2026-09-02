package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.VelocityVoltage;

public class shooter extends SubsystemBase { 

    private final TalonFX shooter;

    private VelocityVoltage VV = new VelocityVoltage(10.0); //PID

    static final int id = 12;

    private double targetRPS = 0; //revolutions per second

    public shooter() {
        shooter = new TalonFX(id);

        TalonFXConfiguration config = new TalonFXConfiguration();

        config.CurrentLimits.SupplyCurrentLimit  = 40;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;

        config.Slot0.kP = 10;
        config.Slot0.kI = 0;
        config.Slot0.kD = 0.05;

        VV.withAcceleration(10).withFeedForward(2).withSlot(0);

        shooter.getConfigurator().apply(config);

    }

    public void runMotor(double duty) {
        shooter.set(duty); //haha code said doodie
    }

    public void runMotorAtRPM(double RPM) {
        shooter.setControl(VV.withVelocity(RPM * 60));
    }



} 
