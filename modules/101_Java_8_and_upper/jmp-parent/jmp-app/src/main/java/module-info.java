module jmp.app {
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;
    requires transitive jmp.service.api;
    requires transitive jmp.bank.api;
}