package com.potato.spring.framework.core.io;

import cn.hutool.core.lang.Assert;
import com.potato.spring.framework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author potato
 * @date 2021/9/22 10:23 下午
 * @blame
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.classLoader = Optional.ofNullable(classLoader).orElse(ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream in = classLoader.getResourceAsStream(path);
        return Optional.ofNullable(in)
                .orElseThrow(() -> new FileNotFoundException(this.path + "cannot be opened because it does not exist."));
    }
}
