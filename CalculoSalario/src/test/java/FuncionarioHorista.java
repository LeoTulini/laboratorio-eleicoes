import main.Funcionario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioHorista {
    protected Funcionario joao;

    @Before
    public void inicializar() {
        joao = new main.FuncionarioHorista("Joao", "12345", 30, 0, 30, 3);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(90 ,joao.getRendimento(), 0.1) ;
    }
}
