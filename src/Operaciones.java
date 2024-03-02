
public class Operaciones {
	public double CelciusFahrenheit(double temperatura){
		return temperatura * 9/5 + 32;
	}
	public double CelciusKelvin(double temperatura){
		return temperatura + 273.15;
	}
	public double CelciusRankin(double temperatura){
		return (temperatura + 32) * 9/5;
	}
	public double FahrenheitCelcius(double temperatura){
		return (temperatura - 32) * 5/9;
	}
	public double FahrenheitKelvin(double temperatura){
		return (temperatura + 459.67) * 5/9;
	}
	public double FahrenheitRankin(double temperatura){
		return temperatura + 459.67;
	}
	public double KelvinCelcius(double temperatura){
		return temperatura - 273.15;
	}
	public double KelvinFahrenheit(double temperatura){
		return (temperatura * 9/5) - 459.67;
	}
	public double KelvinRankin(double temperatura){
		return temperatura * 9/5;
	}
	public double RankinCelcius(double temperatura){
		return (temperatura - 491.67) * 5/9;
	}
	public double RankinFahrenheit(double temperatura){
		return (temperatura * 9/5) - 459.67;
	}
	public double RankinKelvin(double temperatura){
		return temperatura * 5/9;
	}
}