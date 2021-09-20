package org.acme;

import io.fabric8.certmanager.api.model.v1.CertificateList;
import io.fabric8.certmanager.client.CertManagerClient;
import io.fabric8.certmanager.server.mock.EnableCertManagerMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableCertManagerMockClient(crud = true)
public class GreetingResourceTest {

    CertManagerClient client;

    @Test
    void shouldReturnEmptyList() {
        CertificateList certificateList = client.v1().certificates().inNamespace("ns1").list();
        assertNotNull(certificateList);
        assertTrue(certificateList.getItems().isEmpty());
    }

}