open module asortingservice {
    exports asortingservice;
    requires java.logging;
    requires sortingserviceapi;
    uses sortingservice.SortingServiceFactory;
}
