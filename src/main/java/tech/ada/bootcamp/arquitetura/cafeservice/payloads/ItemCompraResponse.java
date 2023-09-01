package tech.ada.bootcamp.arquitetura.cafeservice.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ItemCompraResponse extends ItemCompraRequest{
    private double valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemCompraResponse that = (ItemCompraResponse) o;
        return Double.compare(valor, that.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), valor);
    }
}
