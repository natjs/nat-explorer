//
//  WeexNatRecorder.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatRecorder.h"
#import "NatRecorder.h"
#define kRecordAudioFile @"myRecord.caf"

@implementation WeexNatRecorder
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(start::))
WX_EXPORT_METHOD(@selector(pause:))
WX_EXPORT_METHOD(@selector(stop:))



- (void)start:(NSDictionary *)options :(WXModuleCallback)callback{
    
    [[NatRecorder singletonManger] start:options :^(id error,id result) {
        if (error) {
            if (callback) {
                callback(error);
            }
        }else{
            if (callback) {
                callback(result);
            }
        }

    }];
    
}
- (void)pause:(WXModuleCallback)callback{
    [[NatRecorder singletonManger] pause:^(id error,id result) {
        if (error) {
            if (callback) {
                callback(error);
            }
        }else{
            if (callback) {
                callback(result);
            }
        }

    }];
    
}
- (void)stop:(WXModuleCallback)callback{
    [[NatRecorder singletonManger] stop:^(id error,id result) {
        if (error) {
            if (callback) {
                callback(error);
            }
        }else{
            if (callback) {
                callback(result);
            }
        }

    }];
}


- (void)dealloc{
    [[NatRecorder singletonManger] close];
}


@end
