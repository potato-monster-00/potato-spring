package com.potato.spring.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author potato
 * @date 2021/9/21 11:18 下午
 * @blame
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
