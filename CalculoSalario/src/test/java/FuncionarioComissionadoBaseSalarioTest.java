import main.Funcionario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioComissionadoBaseSalarioTest {
    protected Funcionario sara;

    @Before
    public void inicializar() {
        sara = new main.FuncionarioAssalariado("Sara", "01824", 40, 10000, 3000);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(3001 ,sara.getRendimento(), 0.1) ;
    }
}
