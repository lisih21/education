package app.dto;

import lombok.*;

@Value // с аннотацией Value lombok по умолчанию делает все поля private+final. сеииеры не генерируются. Класс - final
@Builder
public class DepartmentDto {
    Integer id;
    String description;
}
