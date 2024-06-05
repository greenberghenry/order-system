package com.order.system.domain.entity;

import lombok.Data;

@Data
public abstract class BaseEntity<ID> {
    protected ID id;
}
