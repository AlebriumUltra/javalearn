/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package lab1;

import java.io.Serializable;

/**
 *
 * @author dunke
 */
public class RecIntegral implements Serializable 
    {
        private String lowStep;
        private String highStep;
        private String integralStep;
        private String integralResult;
        
        
        public RecIntegral(String lowStep, String highStep, String integralStep) throws NumException
        {
            if(Double.valueOf(lowStep) < 0.000001 
                    || Double.valueOf(lowStep) > 1000000
                    || Double.valueOf(highStep) < 0.000001
                    || Double.valueOf(highStep) > 1000000
                    || Double.valueOf(integralStep) < 0.000001
                    || Double.valueOf(integralStep) > 1000000)
            {
                throw new NumException("Numbers must be between 0.000001 and 1000000");
            }
            this.lowStep = lowStep;
            this.highStep = highStep;
            this.integralStep = integralStep;
            this.integralResult = "0";
        }
        
        public void setResult(String integralResult)
        {
            this.integralResult = integralResult;
        }
        
        public String getLowStep()
        {
            return this.lowStep;
        }
        
        public String getIntegralStep()
        {
            return this.integralStep;
        }
        
        public String getIntegralResult()
        {
            return this.integralResult;
        }
        
         public String getHighStep()
        {
            return this.highStep;
        }
        
         
        public double integralCalculate()
        {
            double a = Double.valueOf(this.lowStep);
            double b = Double.valueOf(this.highStep);
            double h = Double.valueOf(this.integralStep);
            double n = (b-a)/h;
            double result = 0;
            
            for (int i = 0; i < n-1; i++){
                result+=1/(a+i*h)*h;
            }
         
            result+= h*(1/a+1/b)/2;
            this.integralResult = Double.toString(result);
            return result;
        }
        
        
    }
