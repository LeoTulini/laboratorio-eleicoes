import main.Funcionario;
import main.FuncionarioComissionadoBaseSalario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioComissionadoBaseSalarioTest {
    protected FuncionarioComissionadoBaseSalario sara;

    @Before
    public void inicializar() {
        sara = new FuncionarioComissionadoBaseSalario("Sara",
                "01824",
                40,
                10000,
                3000);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(3001 ,sara.getRendimento(), 0.1) ;
    }
}
