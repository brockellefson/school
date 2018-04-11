from scipy import stats
import plotly.plotly as py
import plotly.graph_objs as go
import numpy as np
import scipy
import plotly

class Visual:

    def __init__(self):
        plotly.tools.set_credentials_file(username='assblasster6969', api_key='5Deu2xZxRBqAjahR6Gk6')       #link account

    #runs a test on the 2 datasets given
    def t_test(self, a_data, b_data):

        a_data = np.array(a_data)               #convert to numpy array
        b_data = np.array(b_data)               #convert to numpy array
        t, p = stats.ttest_ind(a_data, b_data)  #get t-score / p-value
        a_mean = np.mean(a_data)                #get mean of a_data
        b_mean = np.mean(b_data)                #get mean of b_data
        print('t score = ' + str(t))            #print results
        print('p score = ' + str(p))

        ya = scipy.stats.norm.pdf(a_data)       #get y-values from a_data
        yb = scipy.stats.norm.pdf(b_data)       #get y-values from b_data
        if (ya.max() >= yb.max()):              #use y values from dataset with
            y2 = ya                             #highest max y-value for graphing
        else:
            y2 = yb

        trace1 = go.Histogram(                  #make histogram for a_data
            x=a_data,
            y=y2,
            showlegend='true',
            text='Mean = ' + str(a_mean),
            name='actor + director pair scores'
        )

        trace2 = go.Histogram(                  #make histogram for b_data
            x=b_data,
            y=y2,
            showlegend='true',
            text='Mean = ' + str(b_mean),
            name='actor solo scores'
        )

        data = [trace1, trace2]

        py.plot(data, filename='normal-dists-plot') #plot histograms


