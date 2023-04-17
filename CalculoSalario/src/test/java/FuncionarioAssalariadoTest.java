import main.Funcionario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioAssalariadoTest {

    protected Funcionario paulo;

    @Before
    public void inicializar() {
        paulo = new main.FuncionarioAssalariado("Paulo", "67890", 70, 0, 3000);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(3000 ,paulo.getRendimento(), 0.1) ;
    }
}
