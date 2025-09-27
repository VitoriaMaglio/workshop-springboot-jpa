package com.estudandoweb.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    private OrderStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
    }
}
//java por padrão atribui um número para cada tipo da sua enum
//primeiro valor é zero,1,2,...
//ent quando instanciar no banco, ele vai gerar uma tabela com esss números
// se depois vc adicionar outro valor no meio da enumeração, vai bugar os outros valores e perder o sentio no banco de dados
//atribuir manualmente um valor para cada tipo enumerado
//métodos estáticos funcionam sem precisar instanciar
