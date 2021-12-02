open module asortingservice {
    requires java.logging;
    requires sortingserviceapi;
    uses sortingservice.SortingServiceFactory;
    uses asortingservice.SortingServices;
}
