package ru.stroy1click.product.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.stroy1click.product.dto.AttributeDto;
import ru.stroy1click.product.exception.ValidationException;
import ru.stroy1click.product.service.attribute.AttributeService;
import ru.stroy1click.product.util.ValidationErrorUtils;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attributes")
@Tag(name = "Attribute Controller", description = "Взаимодействие с атрибутами")
@RateLimiter(name = "attributeLimiter")
public class AttributeController {

    private final AttributeService attributeService;

    private final MessageSource messageSource;

    @GetMapping("/{id}")
    @Operation(summary = "Получение атрибута")
    public ResponseEntity<AttributeDto> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.attributeService.get(id));
    }

    @PostMapping
    @Operation(summary = "Создание атрибута")
    public ResponseEntity<String> create(@RequestBody @Valid AttributeDto attributeDto,
                                         BindingResult bindingResult){
        if(bindingResult.hasErrors()) throw new ValidationException(ValidationErrorUtils.collectErrorsToString(
                bindingResult.getFieldErrors()
        ));

        this.attributeService.create(attributeDto);
        return ResponseEntity.ok(
                this.messageSource.getMessage(
                        "",
                        null,
                        Locale.getDefault()
                )
        );
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление атрибута")
    public ResponseEntity<String> update(@PathVariable("id") Integer id,
                                         @RequestBody @Valid AttributeDto attributeDto,
                                         BindingResult bindingResult){
        if(bindingResult.hasErrors()) throw new ValidationException(ValidationErrorUtils.collectErrorsToString(
                bindingResult.getFieldErrors()
        ));

        this.attributeService.update(id, attributeDto);
        return ResponseEntity.ok(
                this.messageSource.getMessage(
                        "",
                        null,
                        Locale.getDefault()
                )
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление атрибута")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        this.attributeService.delete(id);
        return ResponseEntity.ok(
                this.messageSource.getMessage(
                        "",
                        null,
                        Locale.getDefault()
                )
        );
    }
}
