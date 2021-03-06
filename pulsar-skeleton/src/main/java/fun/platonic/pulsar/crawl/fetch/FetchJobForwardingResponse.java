package fun.platonic.pulsar.crawl.fetch;

import fun.platonic.pulsar.common.HttpHeaders;
import fun.platonic.pulsar.crawl.protocol.ForwardingResponse;
import org.apache.commons.lang3.math.NumberUtils;
import fun.platonic.pulsar.persist.metadata.MultiMetadata;

import static fun.platonic.pulsar.common.config.PulsarConstants.FETCH_PRIORITY_DEFAULT;

/**
 *
 * */
public class FetchJobForwardingResponse extends ForwardingResponse implements HttpHeaders {

    public FetchJobForwardingResponse(MultiMetadata headers, byte[] content) {
        super(headers.get(Q_URL), content, NumberUtils.toInt(headers.get(Q_STATUS_CODE), 404), headers);
    }

    public int getJobId() {
        return NumberUtils.toInt(getHeaders().get(Q_JOB_ID), 0);
    }

    public int getPriority() {
        return NumberUtils.toInt(getHeaders().get(Q_PRIORITY), FETCH_PRIORITY_DEFAULT);
    }

    public String getQueueId() {
        return getHeaders().get(Q_QUEUE_ID);
    }

    public int getItemId() {
        return NumberUtils.toInt(getHeaders().get(Q_ITEM_ID), 0);
    }
}
