下面是原版引用地址，我只是修改了一下别人的库

[![Android Gems](http://www.android-gems.com/badge/tyrantgit/HeartLayout.svg?branch=master)](http://www.android-gems.com/lib/tyrantgit/HeartLayout)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-HeartLayout-brightgreen.svg?style=flat)](http://android-arsenal.com/details/3/2558)

# HeartLayout
periscope like heartlayout

![heartlayout.gif](assets/heartlayout.gif)

## Getting started

In your `build.gradle`:

```gradle
 dependencies {
   implementation 'tyrant:heartlayout:1.0.1'
 }
```

```java
HeartLayout heartLayout = ...;
heartLayout.addHeart(color);
heartLayout.addHeart(color,heartResId,heartBorderResId);
```

## License

    Copyright 2015 tyrantgit

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
