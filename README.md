# Spring Async Completable Future

## Configuração do thread executor
```
com.example.demo.config.ThreadExecutorConfig
```

## Runner da aplicação
```
com.example.demo.DemoRunner
```

## Funcionamento
O serviço [DemoService](src/main/java/com/example/demo/service/DemoService.java) é chamado pelo [Runner](src/main/java/com/example/demo/DemoRunner.java) no start da aplicação e dispara 2 execuções assíncronas ([AsyncService1.callExternalService()](src/main/java/com/example/demo/service/AsyncService1.java) e [AsyncService2.callExternalServiceWithException()](src/main/java/com/example/demo/service/AsyncService2.java)) simulando chamadas à 2 serviços externos com um Thread Sleep.

As execuções dos serviços assíncronos são mapeadas e os tratamentos também são simulados (em caso de sucesso e falha) com os métodos abaixo:
> java.util.concurrent.CompletableFuture.exceptionally

> java.util.concurrent.CompletableFuture.thenApplyAsync

> java.util.concurrent.CompletableFuture.whenComplete



Pelos logs da aplicação é possível monitorar o paralelismo.
