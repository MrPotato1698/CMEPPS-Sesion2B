package pkg;

public class Empleado {
	public enum TipoEmpleado{Vendedor, Encargado};
	public static float calculaNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtras) {
		float nomina = 0;float primas=0; float extras=0;
		if (tipo==TipoEmpleado.Vendedor) {// si es empleado
			nomina = 2000;
		} else {
			nomina = 2500;
		}
		
		if(ventasMes>=1500) {
			primas=200;
		} else if(ventasMes>=1000) {
			primas=100;
		}
		
		extras=horasExtras*30;
		return nomina+primas+extras;
	}

	public static float calculaNominaNeta(float nominaBruta) {
		float retencion=0;
		if (nominaBruta>2500) {
			retencion=0.18f;
		}else if(nominaBruta>2000) {
			retencion=0.15f;
		}
		return nominaBruta*(1-retencion);
	}
}