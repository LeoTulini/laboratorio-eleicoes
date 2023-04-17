import main.Funcionario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioComissionadoTest {
    protected Funcionario renata;

    @Before
    public void inicializar() {
        renata = new main.FuncionarioComissionado("Renata", "19276", 55, 40000);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(22000 ,renata.getRendimento(), 0.1) ;
    }

}
