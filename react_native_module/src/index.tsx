import { NativeModules } from 'react-native';
export const getGreeting = () => NativeModules.ReactNativeModule.getGreeting();
