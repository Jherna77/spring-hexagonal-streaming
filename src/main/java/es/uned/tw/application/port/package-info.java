/**
 * This module is about inbound and outbound interface ports for application
 * <p>
 * This module contains all interface ports for core logic application, defining the
 * behaviour of the application. The ports will be used in the service implementations. Their
 * implementation will be injected with dependency inversion from infrastructure layer
 * </p>
 * <p>
 * This ports acts as a gateway through which communication takes place as an inbound or
 * outbound port. The inbound port is like a service interface that exposes the core logic
 * to the outside resources. An outbound port is like a repository interface that facilitates
 * communication from application to persistence system
 * </p>
 *
 * @author Jorge Hernandez
 * @version 1.0
 * @since 1.0
 */
package es.uned.tw.application.port;

