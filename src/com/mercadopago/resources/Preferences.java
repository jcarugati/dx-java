package com.mercadopago.resources;

import com.mercadopago.core.MPBase;
import com.mercadopago.core.MPBaseResponse;
import com.mercadopago.core.annotations.rest.GET;
import com.mercadopago.core.annotations.rest.POST;
import com.mercadopago.core.annotations.rest.PUT;
import com.mercadopago.core.annotations.validation.NotNull;
import com.mercadopago.core.annotations.validation.Numeric;
import com.mercadopago.core.annotations.validation.Size;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.datastructures.preferences.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Mercado Pago SDK
 * This resource allows you to set up, during the Payment process, all the item information,
 * any accepted means of Payment and many other options.
 *
 * Created by Eduardo Paoletta on 11/9/16.
 */
public class Preferences extends MPBase {

    @NotNull private ArrayList<Item> items = null;
    @NotNull private Payer payer = null;
    private PaymentMethods paymentMethods = null;
    private Shipments shipments = null;
    private BackUrls backUrls = null;
    @Size(max=500) private String notificationUrl = null;
    private String id = null;
    private String initPoint = null;
    private String sandboxInitPoint = null;
    private Date dateCreated = null;
    private OperationType operationType = null;
    public enum OperationType {
        regular_payment,
        money_transfer
    }
    @Size(max=600) private String additionalInfo = null;
    private AutoReturn autoReturn = null;
    public enum AutoReturn {
        approved,
        all
    }
    @Size(max=256) private String externalReference = null;
    private Boolean expires = null;
    private Date expirationDateFrom = null;
    private Date expirationDateTo = null;
    private Integer collectorId = null;
    private Integer clientId = null;
    @Size(max=256) private String marketplace = null;
    @Numeric(min=.01f) private Float marketplaceFee = null;
    private DifferentialPricing differentialPricing = null;


    public ArrayList<Item> getItems() {
        return items;
    }

    public Preferences setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    public ArrayList<Item> appendItem(Item item) {
        if (items == null)
            items = new ArrayList<Item>();
        items.add(item);
        return getItems();
    }

    public Payer getPayer() {
        return payer;
    }

    public Preferences setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public Preferences setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
        return this;
    }

    public Shipments getShipments() {
        return shipments;
    }

    public Preferences setShipments(Shipments shipments) {
        this.shipments = shipments;
        return this;
    }

    public BackUrls getBackUrls() {
        return backUrls;
    }

    public Preferences setBackUrls(BackUrls backUrls) {
        this.backUrls = backUrls;
        return this;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public Preferences setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public String getSandboxInitPoint() {
        return sandboxInitPoint;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Preferences setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public AutoReturn getAutoReturn() {
        return autoReturn;
    }

    public Preferences setAutoReturn(AutoReturn autoReturn) {
        this.autoReturn = autoReturn;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public Preferences setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public Boolean getExpires() {
        return expires;
    }

    public Preferences setExpires(Boolean expires) {
        this.expires = expires;
        return this;
    }

    public Date getExpirationDateFrom() {
        return expirationDateFrom;
    }

    public Preferences setExpirationDateFrom(Date expirationDateFrom) {
        this.expirationDateFrom = expirationDateFrom;
        return this;
    }

    public Date getExpirationDateTo() {
        return expirationDateTo;
    }

    public Preferences setExpirationDateTo(Date expirationDateTo) {
        this.expirationDateTo = expirationDateTo;
        return this;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public Preferences setMarketplace(String marketplace) {
        this.marketplace = marketplace;
        return this;
    }

    public Float getMarketplaceFee() {
        return marketplaceFee;
    }

    public Preferences setMarketplaceFee(Float marketplaceFee) {
        this.marketplaceFee = marketplaceFee;
        return this;
    }

    public DifferentialPricing getDifferentialPricing() {
        return differentialPricing;
    }

    public Preferences setDifferentialPricing(DifferentialPricing differentialPricing) {
        this.differentialPricing = differentialPricing;
        return this;
    }



    public MPBaseResponse load(String id) throws MPException {
        return load(id, WITHOUT_CACHE);
    }

    @GET(path="/checkout/preferences/:param")
    public MPBaseResponse load(String id, Boolean useCache) throws MPException {
        return super.processMethod("load", id, useCache);
    }

    @POST(path="/checkout/preferences")
    public MPBaseResponse create() throws MPException {
        return super.processMethod("create");
    }

    @PUT(path="/checkout/preferences/:param")
    public MPBaseResponse update(String id) throws MPException {
        return super.processMethod("update", id);
    }

}
